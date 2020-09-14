package main.java.com.lemsviat.lemhomework18;

public interface SkillRepository {
    public void save(Skill skill);

    public void update(Skill skill);

    public Skill findById(int SkillId);

    public void delete(Skill skill);
}
