package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.*;

public class GunRepository implements Repository<Gun> {

    private List<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.models;
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        if (models.stream().noneMatch(g -> g.getName().equals(model.getName()))) {
            this.models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        return models.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    }
}
