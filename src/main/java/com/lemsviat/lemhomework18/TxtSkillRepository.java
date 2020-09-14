package main.java.com.lemsviat.lemhomework18;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TxtSkillRepository implements SkillRepository{

    final static String FILE_NAME = "Skills.txt";

    public TxtSkillRepository() { }

    public Skill findById(int SkillId) {
        Skill skill = null;
        if (SkillId < 1) {
            System.out.println("Skill not exists.");
        } else {
            ifSkillRecord(SkillId);
            skill = new Skill(SkillId, mapSkills.get(SkillId));
        }
        return skill;
    }

    Map<Integer, String> mapSkills = new HashMap<>();

    public void save(Skill skill) {
        if (mapSkills.containsKey(skill.getSkillId()))
            System.out.printf("Skill with id %s is exist. We should skip it.\n", skill.getSkillId());
        else {
            writeMapToFile(skill);
        }
    }

    public void writeMapToFile(Skill skill) {
        mapSkills.put(skill.getSkillId(), skill.getSkillName());
        try {
            Files.write(Paths.get(FILE_NAME),
                    mapSkills.entrySet().stream().map(k -> k.getKey() + ": " + k.getValue()).collect(Collectors.toList()),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean ifSkillRecord(int id) {
        boolean success = false;
        if (mapSkills.containsKey(id)) {
            success = true;
        } else System.out.println("Failed to find the skill.");
        return success;
    }

    public void update(Skill skill) {
        if (skill.getSkillId() < 1) {
            System.out.println("Skill not exists.");
        } else {
            ifSkillRecord(skill.getSkillId());
            writeMapToFile(skill);
        }
    }

    public void delete(Skill skill) {
        if (skill.getSkillId() < 1) {
            System.out.println("Skill not exists.");
        } else mapSkills.remove(skill.getSkillId(),skill.getSkillName());
            try {
                Files.write(Paths.get(FILE_NAME),
                        mapSkills.entrySet().stream().map(k -> k.getKey() + ": " + k.getValue()).collect(Collectors.toList()),
                        StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
