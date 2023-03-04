package sn.mouhamadou.mouhamadou.Dto;


public class CandidatDto {

    private String email;
    private String prenom;
    private String nom;
    private int age;
    private String adresse;
    private double telephone;
    private String specialite;
    private String niveauEtude;
    private String experiences;

    private String password;

    public CandidatDto() {
    }

    public CandidatDto( String email, String prenom, String nom, int age, String adresse, double telephone, String specialite, String niveauEtude, String experiences, String password) {

        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.adresse = adresse;
        this.telephone = telephone;
        this.specialite = specialite;
        this.niveauEtude = niveauEtude;
        this.experiences = experiences;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getTelephone() {
        return telephone;
    }

    public void setTelephone(double telephone) {
        this.telephone = telephone;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }
    @Override
    public String toString() {
        return "CandidatDTO{" +
                ", CandidatName='" + prenom + '\'' +
                ", CandidatEmail='" + email + '\'' +
                ", Candidatpassword='" + password + '\'' +
                '}';
    }
}
