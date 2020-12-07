import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        if (size > 0) {
            for (int i = 0; i <= size; i++) {
                storage[i] = null;
            }
            size = 0;
        }
    }

    void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Sorry, base is full. The resume did not save.");
        } else {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        System.out.println("Sorry, resume \"" + uuid + "\" did not found.");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                System.arraycopy(storage, i + 1, storage, i, size - i - 1);
                storage[size] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storageWithout0 = new Resume[size];
        System.arraycopy(storage, 0, storageWithout0, 0, size);
        return storageWithout0;
    }

    int size() {
        return size;
    }
}
