package hr.algebra.studentprojectapiinteropability.domain;

public class Grades {
    private Long id;
    private int mathGrade;
    private int geographyGrade;
    private int HistoryGrade;
    private int EnglishGrade;
    private int BiologyGrade;

    public Grades() {

    }

    public Grades(long id, int mathGrade, int geographyGrade, int HistoryGrade, int EnglishGrade, int BiologyGrade) {
        this.id = id;
        this.mathGrade = mathGrade;
        this.geographyGrade = geographyGrade;
        this.HistoryGrade = HistoryGrade;
        this.EnglishGrade = EnglishGrade;
        this.BiologyGrade = BiologyGrade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    public int getGeographyGrade() {
        return geographyGrade;
    }

    public void setGeographyGrade(int geographyGrade) {
        this.geographyGrade = geographyGrade;
    }

    public int getHistoryGrade() {
        return HistoryGrade;
    }

    public void setHistoryGrade(int historyGrade) {
        HistoryGrade = historyGrade;
    }

    public int getEnglishGrade() {
        return EnglishGrade;
    }

    public void setEnglishGrade(int englishGrade) {
        EnglishGrade = englishGrade;
    }

    public int getBiologyGrade() {
        return BiologyGrade;
    }

    public void setBiologyGrade(int biologyGrade) {
        BiologyGrade = biologyGrade;
    }
}
