package com.br.franchises.mock;

import com.br.franchises.R;

import com.br.franchises.model.VO.FranchiseVO;
import com.br.franchises.model.VO.RestaurantVO;

import java.util.ArrayList;

public class Mock {
    public static ArrayList<FranchiseVO> data() {
        ArrayList<FranchiseVO> franchises = new ArrayList<>();

        ArrayList<RestaurantVO> restaurants1 = new ArrayList<>();
        restaurants1.add(new RestaurantVO("Restaurante 1", "Rua Santos Saraiva, 1", "Floripa", R.drawable.mac));
        restaurants1.add(new RestaurantVO("Restaurante 2", "Rua Santos Saraiva, 2", "Floripa", R.drawable.mac));
        restaurants1.add(new RestaurantVO("Restaurante 3", "Rua Santos Saraiva, 3", "Floripa", R.drawable.mac));

        ArrayList<RestaurantVO> restaurants2 = new ArrayList<>();
        restaurants2.add(new RestaurantVO("Restaurante 4", "Rua Santos Saraiva, 4", "Floripa", R.drawable.subway));
        restaurants2.add(new RestaurantVO("Restaurante 5", "Rua Santos Saraiva, 5", "Floripa", R.drawable.subway));
        restaurants2.add(new RestaurantVO("Restaurante 6", "Rua Santos Saraiva, 6", "Floripa", R.drawable.subway));

        ArrayList<RestaurantVO> restaurants3 = new ArrayList<>();
        restaurants3.add(new RestaurantVO("Restaurante 7", "Rua Santos Saraiva, 7", "Floripa", R.drawable.burguerking));
        restaurants3.add(new RestaurantVO("Restaurante 8", "Rua Santos Saraiva, 8", "Floripa", R.drawable.burguerking));
        restaurants3.add(new RestaurantVO("Restaurante 9", "Rua Santos Saraiva, 9", "Floripa", R.drawable.burguerking));

        ArrayList<RestaurantVO> restaurants4 = new ArrayList<>();
        restaurants4.add(new RestaurantVO("Restaurante 10", "Rua Santos Saraiva, 10", "Floripa", R.drawable.bobs));
        restaurants4.add(new RestaurantVO("Restaurante 11", "Rua Santos Saraiva, 11", "Floripa", R.drawable.bobs));
        restaurants4.add(new RestaurantVO("Restaurante 12", "Rua Santos Saraiva, 12", "Floripa", R.drawable.bobs));

        franchises.add(new FranchiseVO("Franquia 1", "Descrição 1", R.drawable.mac, restaurants1));
        franchises.add(new FranchiseVO("Franquia 2", "Descrição 2", R.drawable.subway, restaurants2));
        franchises.add(new FranchiseVO("Franquia 3", "Descrição 3", R.drawable.burguerking, restaurants3));
        franchises.add(new FranchiseVO("Franquia 4", "Descrição 4", R.drawable.bobs, restaurants4));

        return franchises;
    }
}
