package securityservice.api.response.user;

import lombok.Getter;
import lombok.Setter;
import securityservice.api.response.role.RoleResponse;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Getter
@Setter
public class UserResponse implements List<UserResponse> {

    private Integer id;

    private String fullName;

    private String email;

    private RoleResponse role;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<UserResponse> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(UserResponse userResponse) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends UserResponse> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends UserResponse> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public UserResponse get(int index) {
        return null;
    }

    @Override
    public UserResponse set(int index, UserResponse element) {
        return null;
    }

    @Override
    public void add(int index, UserResponse element) {

    }

    @Override
    public UserResponse remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<UserResponse> listIterator() {
        return null;
    }

    @Override
    public ListIterator<UserResponse> listIterator(int index) {
        return null;
    }

    @Override
    public List<UserResponse> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}
