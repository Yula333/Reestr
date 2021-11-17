package com.mycompany;

import com.mycompany.models.Category;
import com.mycompany.repo.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategoryTests {

    @Autowired
    private CategoryRepository repo;

    @Test
    public void testCreateCategory(){
        Category categorySave = repo.save(new Category("Телевизоры"));
        assertThat(categorySave.getId()).isGreaterThan(0);

        Category categorySave2 = repo.save(new Category("Пылесосы"));
        assertThat(categorySave2.getId()).isGreaterThan(0);

        Category categorySave3 = repo.save(new Category("Холодильники"));
        assertThat(categorySave3.getId()).isGreaterThan(0);

        Category categorySave4 = repo.save(new Category("Смартфоны"));
        assertThat(categorySave4.getId()).isGreaterThan(0);

        Category categorySave5 = repo.save(new Category("Компьютеры"));
        assertThat(categorySave5.getId()).isGreaterThan(0);
    }
}
