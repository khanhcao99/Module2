public interface CRUD <E> {
    E add(E e);
    E getById(int id);
    void updateById(int index, E e);
    E deleteById(int id);
    E deleteByAll();
    void displayByid(int id);
    void displayAll();
}
