public class User extends Entity{
    private String name;

    public User(String name) {
        this.name = name;
    }
    public String fileName(){
        return "user:"+name;
    }

    @Override
    public boolean validar() {
        if (name.length()>5){
            return true;
        }
        return false;
    }
}
