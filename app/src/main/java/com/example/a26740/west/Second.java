package com.example.a26740.west;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Second extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private List<Book> bookList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        initBook();
        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.button_2);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final BookAdapter adapter = new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                if(!"".equals(content)){
                    Book book = new Book(content);
                    bookList.add(0,new Book(content));
                    adapter.notifyItemInserted(0);
                    recyclerView.getLayoutManager().scrollToPosition(0);
                    editText.setText("");
                }
            }
        });
    }


    private void initBook(){
        for(int i=0;i<2;i++){
            Book gaoshu = new Book("高数");
            bookList.add(gaoshu);
            Book lisan = new Book("离散");
            bookList.add(lisan);
            Book dawu = new Book("大雾");
            bookList.add(dawu);
            Book xiandai = new Book("线代");
            bookList.add(xiandai);
            Book shuluo = new Book("数逻");
            bookList.add(shuluo);
        }

    }
}
