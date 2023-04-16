package service;

/**
 * @author quincy
 * @create 2023 - 04 - 16 18:25
 */
public class WorldServiceImpl implements WorldService{

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void explode() {
        System.out.println("The" + name + " is going to explode");
    }

    @Override
    public String getName() {
        return name;
    }
}
