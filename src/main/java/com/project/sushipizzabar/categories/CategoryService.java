package com.project.sushipizzabar.categories;

import com.project.sushipizzabar.food.dao.FoodRepository;
import com.project.sushipizzabar.food.model.Food;
import com.project.sushipizzabar.food.model.FoodType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final FoodRepository foodRepository;

    public List<Food> getFoodByPageNumber(String type, QPageRequest pageable) {
        return new ArrayList<>(foodRepository.findAllByType(FoodType.getByName(type), pageable));
    }

}
