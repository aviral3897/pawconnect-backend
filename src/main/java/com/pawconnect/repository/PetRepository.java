    package com.pawconnect.repository;

    import com.pawconnect.model.Pet;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.List;

    public interface PetRepository extends JpaRepository<Pet, Long> {

        List<Pet> findByOwnerEmail(String ownerEmail);

        List<Pet> findByOwnerEmailNot(String ownerEmail);
    }