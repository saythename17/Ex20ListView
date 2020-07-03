package com.icandothisallday2020.ex20listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter adapter; //참조변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        //리스트뷰에서 보여줄 뷰들을 만들어 주는 Adapter 객체
        adapter=ArrayAdapter.createFromResource(this,R.array.identifier,R.layout.list_item);
        //           └static method _ parameter: context, data(대량의 데이터 배열), 설계한 모양(시안)
        //Set adapter to listView
        listView.setAdapter(adapter);
        //리스트뷰의 항목(item)을 클릭하는 것을 듣는 리스너 객체 생성 & 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //                 click 된 뷰를 가진 리스트뷰 └눌려진 뷰  └뷰배열번호 └설정된식별자
                //*별도의 지정이 없을시 position==id
                //res 창고를 관리하는 관리자 객체 소환
                Resources res=getResources();

                //res/values/arrays.xml 문서안 identifier 변수를 가진 배열 얻어오기
                String[] arr=res.getStringArray(R.array.identifier);
                Toast.makeText(MainActivity.this,arr[position],Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            //보통 롱클릭메소드에 팝업메뉴를 만들어서 보여줌
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"☆",Toast.LENGTH_SHORT).show();
                return true;//false 일 경우 onClick()도 같이 발동
            }        });
    }
}
