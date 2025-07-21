package src.br.com.dio.model;

import java.util.ArrayList;
import java.util.List;

import src.br.com.dio.exception.UserNotFoundException;

public class UserDAO {

    private long nextId = 1L;
    private List<UserModel> models = new ArrayList<> ();

    public UserModel save(final UserModel model){
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model){
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public UserModel findById(final long id){
        var message = String.format("User not found with this id: ", id);
        return models.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));
        
    }

    public String delete(final long id){
        var toDelete = findById(id);
        models.remove(toDelete);
        return "User deleted with sucess";
    }

    public List<UserModel> findAll() {
        return models;
    }


}
