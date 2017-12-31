package com.sigilworks.mtadata;

/**
 * User: tj
 * Date: 12/30/17
 * Time: 8:43 PM
 */
public enum AuditType {
    REGULAR("REGULAR"),
    RECOVERY("RECOVR AUD");

    private String desc;

    AuditType(String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return desc;
    }

    public static AuditType fromDescription(String desc) {
        AuditType found = null;
        for (AuditType auditType : AuditType.values()) {
            if (auditType.getDescription().equalsIgnoreCase(desc)) {
                found = auditType;
            }
        }
        return found;
    }
}
