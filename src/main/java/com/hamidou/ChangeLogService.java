package com.hamidou;

import org.apache.commons.lang3.StringUtils;
import org.javers.common.string.PrettyValuePrinter;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChangeLogService {

    public List<ChangeEntry> computeEmployeeChanges(int employeeId) {

            Employee hamidouOld = new Employee();
            hamidouOld.setId(1);
            hamidouOld.setFirstName("Hamidou");
            hamidouOld.setLastName("Barry");
            hamidouOld.setHireDate(Instant.now());
            hamidouOld.setSalary(BigDecimal.valueOf(20000));
            hamidouOld.setBirthDate(new Date());
            hamidouOld.getAddressList().add(new Address(1, "111 job road", "Awesome City", "Vibrant State", 12345));
            hamidouOld.getAddressList().add(new Address(2, "222 job road", "Great City", "Rocky State", 35689));

            Employee hamidouNew = new Employee();
            hamidouNew.setId(1);
            hamidouNew.setFirstName("Hamidou New");
            hamidouNew.setLastName("Barry New");
            hamidouNew.setHireDate(Instant.now());
            hamidouNew.setSalary(BigDecimal.valueOf(50000));
            hamidouNew.setBirthDate(new Date());
            hamidouNew.getAddressList().add(new Address(1, "111 job avenue", "Awesome City", "Vibrant State", 12345));
            //hamidouNew.getAddressList().add(new Address(2, "222 Guess Drive", "Great City", "Rocky State", 35689));

            Javers javers = JaversBuilder.javers().build();
            Diff objectDiffs = javers.compare(hamidouOld, hamidouNew);
            List<ChangeEntry> changeEntries = objectDiffs.getChanges().stream().map(change -> {
                    final String formattedEntry = (change.getAffectedGlobalId() + " & " + change.prettyPrint(PrettyValuePrinter.getDefault())).replace("\n", " ");
                    return buildChangeEntry(formattedEntry, change.toString());
            }).collect(Collectors.toList());
            return changeEntries;
    }

    private ChangeEntry buildChangeEntry(String formattedEntry, String rawEntry) {
            ChangeEntry entry = new ChangeEntry();
            // get entityType and entityKey
            String[] entityTypeAndKey = StringUtils.substringBefore(formattedEntry, "&").trim().split("/");
            if (entityTypeAndKey.length > 1) {
                    entry.setEntityType(entityTypeAndKey[0]);
                    entry.setEntityKey(entityTypeAndKey[1]);
            }
            if (StringUtils.containsIgnoreCase(formattedEntry, ChangeType.NEW_OBJECT.displayName()) ||
                    StringUtils.containsIgnoreCase(formattedEntry, ChangeType.ADDED.displayName())) {
                    // set changeType and return
                    entry.setChangeType(ChangeType.NEW_OBJECT.displayName());
            } else if (StringUtils.containsIgnoreCase(formattedEntry, ChangeType.REMOVED.displayName())) {
                    // set changeType and return
                    entry.setChangeType(ChangeType.REMOVED.displayName());
            } else if (StringUtils.containsIgnoreCase(formattedEntry, ChangeType.CHANGED.displayName())) {
                    // set changeType
                    entry.setChangeType(ChangeType.CHANGED.displayName());
                    // set field name
                    entry.setFieldName( StringUtils.substringBetween(formattedEntry, "&", "value").trim());
                    // old value
                    entry.setOldValue(StringUtils.substringBetween(formattedEntry, "from", "to").trim());
                    // new value
                    entry.setNewValue(StringUtils.substringAfterLast(formattedEntry, "to"));
            }
            // description
            entry.setDescription(StringUtils.replace(rawEntry, "\n", " "));
            return entry;
    }
}
