package main.java.com.lemsviat.lemhomework18;

public class SkillController {
    SkillRepository skillRepository;
    TxtSkillRepository txtSkillRepository;
    CsvSkillRepository csvSkillRepository;

    public void createTxtRepo() {
        if (skillRepository != null) {
            skillRepository = txtSkillRepository;
            //System.out.println("switched to txtrepo");
        }
        if (skillRepository == null || skillRepository instanceof CsvSkillRepository) {
            txtSkillRepository = new TxtSkillRepository();
            skillRepository = txtSkillRepository;
            //System.out.println("txtrepo created");
        }
    }

    public void createCsvRepo() {
        if (skillRepository != null) {
            skillRepository = csvSkillRepository;
            //System.out.println("switched to csvrepo");
        }
        if (skillRepository == null || skillRepository instanceof TxtSkillRepository) {
            csvSkillRepository = new CsvSkillRepository();
            skillRepository = csvSkillRepository;
            //System.out.println("csvrepo created");
        }

    }

    public void create(int id, String name) {
        skillRepository.save(new Skill(id, name));
    }

    public void update(int skillId, String skillName) {
        Skill skill = skillRepository.findById(skillId);
        skill.setSkillName(skillName);
        skillRepository.update(skill);
    }

    public Skill read(int skillId) {
        return skillRepository.findById(skillId);
    }

    public void deleteById(int skillId) {
        Skill skill = skillRepository.findById(skillId);
        skillRepository.delete(skill);
    }
}
