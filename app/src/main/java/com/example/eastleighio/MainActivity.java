package com.example.eastleighio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.eastleighio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RecyclerView recyclerView = findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        replaceFragment(new HomeFragment());

        ProductData[] productData= new ProductData[]{
                new ProductData("Lace Handbag","Woolen", R.drawable.handyy),
                new ProductData("Sneakers","Sporty", R.drawable.sneaky),
                new ProductData("OfficialWear","Official", R.drawable.official),
                new ProductData("Coats","Men's wear", R.drawable.coats),
                new ProductData("Lace Handbag","", R.drawable.handyy),
                new ProductData("Lace Handbag","Woolen", R.drawable.handyy),
                new ProductData("Lace Handbag","Woolen", R.drawable.handyy),
                new ProductData("Lace Handbag","Woolen", R.drawable.handyy)
        };

        ProductAdapter productAdapter = new ProductAdapter(productData, MainActivity.this);
        recyclerView.setAdapter(productAdapter);




        binding.bottomNavigationView.setOnItemSelectedListener(item ->{
            switch(item.getItemId()){
                case R.id.home:
//                    replaceFragment(new HomeFragment())
                    myReplaceFragment(new HomeFragment());
                    break;
                case R.id.ShoppingCart:
//                    replaceFragment(new ShoppingCartFragment());
                    Toast.makeText(getApplicationContext(), "Shopping cart clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.Menuu:
                    replaceFragment(new TestFragment());
                    Toast.makeText(this, "Menu clicked", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.Account:
                    replaceFragment(new AccountFragment());
                    break;
            }

            return true;

        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    public void myReplaceFragment(Fragment frag){

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,frag).commit();
    }
}