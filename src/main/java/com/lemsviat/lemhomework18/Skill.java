package main.java.com.lemsviat.lemhomework18;

public class Skill {
    private int skillId;
    private String skillName;

    @Override
    public String toString() {
        return "Skill [" +
                "skillId = " + skillId +
                ", skillName ='" + skillName + '\'' +
                ']';
    }

    public Skill(int skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
