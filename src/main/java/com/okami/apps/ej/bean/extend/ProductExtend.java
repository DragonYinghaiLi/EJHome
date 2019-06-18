package com.okami.apps.ej.bean.extend;

import com.okami.apps.ej.bean.Category;
import com.okami.apps.ej.bean.Product;

public class ProductExtend extends Product {
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



}
