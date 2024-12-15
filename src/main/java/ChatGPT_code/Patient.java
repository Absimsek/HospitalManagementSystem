package ChatGPT_code;

class Patient {
    private String id;
    private String name;
    private String medicalHistory;

    public Patient(String id, String name, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.medicalHistory = medicalHistory;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getMedicalHistory() { return medicalHistory; }

    @Override
    public String toString() {
        return "Patient[ID: " + id + ", Name: " + name + "]";
    }
}