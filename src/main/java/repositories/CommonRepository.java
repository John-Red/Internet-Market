package repositories;

import java.util.List;

public interface CommonRepository {
    List<?> get();

    boolean delete(Integer id);
}
