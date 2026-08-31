# Smart Medical Monitoring System Report

## Summary

- Total Requirements: 16
- Total Components: 7
- Total Traceability Links: 16

## Requirements


### REQ-F-001 - Receive Heart-Rate Measurement

The system shall receive heart-rate measurements from a connected monitoring device.

- Type: FUNCTIONAL
- Priority: HIGH
- Verification Method: INTEGRATION_TEST


### REQ-F-002 - Associate Measurement with Patient

The system shall associate each received heart-rate measurement with the correct patient using a unique patient identifier.

- Type: FUNCTIONAL
- Priority: HIGH
- Verification Method: INTEGRATION_TEST


### REQ-F-003 - Evaluate Heart-Rate Measurement

The system shall compare each received heart-rate measurement against the configured minimum and maximum thresholds for the associated patient.

- Type: FUNCTIONAL
- Priority: HIGH
- Verification Method: UNIT_TEST


### REQ-F-004 - Detect Abnormal Heart Rate

The system shall classify a heart-rate measurement as abnormal when it is below the configured minimum threshold or above the configured maximum threshold.

- Type: FUNCTIONAL
- Priority: HIGH
- Verification Method: UNIT_TEST


### REQ-F-005 - Notify Assigned Nurse

The system shall send an alert to the patient's assigned nurse when an abnormal heart-rate measurement is detected.

- Type: FUNCTIONAL
- Priority: HIGH
- Verification Method: INTEGRATION_TEST


### REQ-F-006 - Acknowledge Alert

The system shall allow the assigned nurse to acknowledge an abnormal-heart-rate alert.

- Type: FUNCTIONAL
- Priority: HIGH
- Verification Method: INTEGRATION_TEST


### REQ-F-007 - Escalate Unacknowledged Alert

The system shall escalate an abnormal-heart-rate alert if the assigned nurse has not acknowledged it within 60 seconds.

- Type: FUNCTIONAL
- Priority: HIGH
- Verification Method: INTEGRATION_TEST


### REQ-F-008 - Support Multiple Patients

The system shall support simultaneous monitoring of multiple patients.

- Type: FUNCTIONAL
- Priority: HIGH
- Verification Method: SYSTEM_TEST


### REQ-F-009 - Register Patient

The system shall allow an authorized user to register a patient for heart-rate monitoring.

- Type: FUNCTIONAL
- Priority: HIGH
- Verification Method: INTEGRATION_TEST


### REQ-F-010 - Configure Patient Thresholds

The system shall allow an authorized user to configure minimum and maximum heart-rate thresholds for each patient.

- Type: FUNCTIONAL
- Priority: HIGH
- Verification Method: INTEGRATION_TEST


### REQ-D-001 - Record Abnormal Event

The system shall store every detected abnormal heart-rate event.

- Type: DATA
- Priority: HIGH
- Verification Method: INTEGRATION_TEST


### REQ-D-002 - Store Abnormal Event Information

The system shall store the patient identifier, heart-rate value, timestamp, severity, and notification status for every abnormal event.

- Type: DATA
- Priority: HIGH
- Verification Method: INTEGRATION_TEST


### REQ-D-003 - Retain Monitoring Records

The system shall retain stored monitoring records for a configurable retention period.

- Type: DATA
- Priority: MEDIUM
- Verification Method: INTEGRATION_TEST


### REQ-P-001 - Process Five-Second Measurements

The system shall process heart-rate measurements received from each monitoring device at five-second intervals.

- Type: PERFORMANCE
- Priority: HIGH
- Verification Method: PERFORMANCE_TEST


### REQ-R-001 - Detect Device Disconnection

The system shall generate a technical alert when a monitoring device becomes disconnected or stops providing heart-rate measurements.

- Type: RELIABILITY
- Priority: HIGH
- Verification Method: INTEGRATION_TEST


### REQ-S-001 - Restrict Patient Data Access

The system shall restrict access to patient monitoring information to authorized users.

- Type: SECURITY
- Priority: HIGH
- Verification Method: SECURITY_TEST



## Components


### CMP-001 - DeviceInterface

- Type: INTERFACE
- Responsibility: Receive heart-rate measurements from external monitoring devices and forward them to the monitoring service.
- Dependencies: CMP-002


### CMP-002 - MonitoringService

- Type: SERVICE
- Responsibility: Associate measurements with patients, retrieve patient thresholds, evaluate heart-rate measurements, and detect abnormalities.
- Dependencies: CMP-004, CMP-005, CMP-003


### CMP-003 - AlertService

- Type: SERVICE
- Responsibility: Create alerts, notify nurses, track acknowledgments, and escalate unacknowledged alerts.
- Dependencies: CMP-005, CMP-006


### CMP-004 - PatientRepository

- Type: REPOSITORY
- Responsibility: Store and retrieve patient monitoring information, assigned nurses, and heart-rate thresholds.
- Dependencies: 


### CMP-005 - EventRepository

- Type: REPOSITORY
- Responsibility: Store abnormal heart-rate events and manage event and alert status information.
- Dependencies: 


### CMP-006 - NurseInterface

- Type: INTERFACE
- Responsibility: Display alerts, allow nurses to acknowledge alerts, and provide access to monitoring information and abnormal-event history.
- Dependencies: CMP-003, CMP-004, CMP-005


### CMP-007 - AdministrationInterface

- Type: INTERFACE
- Responsibility: Allow authorized users to register patients, assign nurses, and configure heart-rate thresholds.
- Dependencies: CMP-004



## Traceability


### Traceability Link

- Requirement ID: REQ-F-001
- Component IDs: CMP-001
- Verification ID: TEST-F-001


### Traceability Link

- Requirement ID: REQ-F-002
- Component IDs: CMP-002, CMP-004
- Verification ID: TEST-F-002


### Traceability Link

- Requirement ID: REQ-F-003
- Component IDs: CMP-002, CMP-004
- Verification ID: TEST-F-003


### Traceability Link

- Requirement ID: REQ-F-004
- Component IDs: CMP-002
- Verification ID: TEST-F-004


### Traceability Link

- Requirement ID: REQ-F-005
- Component IDs: CMP-003, CMP-006
- Verification ID: TEST-F-005


### Traceability Link

- Requirement ID: REQ-F-006
- Component IDs: CMP-003, CMP-006
- Verification ID: TEST-F-006


### Traceability Link

- Requirement ID: REQ-F-007
- Component IDs: CMP-003
- Verification ID: TEST-F-007


### Traceability Link

- Requirement ID: REQ-F-008
- Component IDs: CMP-002
- Verification ID: TEST-F-008


### Traceability Link

- Requirement ID: REQ-F-009
- Component IDs: CMP-007, CMP-004
- Verification ID: TEST-F-009


### Traceability Link

- Requirement ID: REQ-F-010
- Component IDs: CMP-007, CMP-004
- Verification ID: TEST-F-010


### Traceability Link

- Requirement ID: REQ-D-001
- Component IDs: CMP-002, CMP-005
- Verification ID: TEST-D-001


### Traceability Link

- Requirement ID: REQ-D-002
- Component IDs: CMP-005
- Verification ID: TEST-D-002


### Traceability Link

- Requirement ID: REQ-D-003
- Component IDs: CMP-005
- Verification ID: TEST-D-003


### Traceability Link

- Requirement ID: REQ-P-001
- Component IDs: CMP-001, CMP-002
- Verification ID: TEST-P-001


### Traceability Link

- Requirement ID: REQ-R-001
- Component IDs: CMP-001, CMP-002
- Verification ID: TEST-R-001


### Traceability Link

- Requirement ID: REQ-S-001
- Component IDs: CMP-006, CMP-007
- Verification ID: TEST-S-001

