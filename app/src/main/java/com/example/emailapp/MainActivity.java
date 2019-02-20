package com.example.emailapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EmailAdapter.EmailItemClicked, View.OnClickListener {

    private List<EmailItem> list = generateEmailList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView emailRecycler = findViewById(R.id.email_recycler_view);
        emailRecycler.setLayoutManager(new LinearLayoutManager(this));
        EmailAdapter emailAdapter = new EmailAdapter(list, this);
        emailRecycler.setAdapter(emailAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    private List<EmailItem> generateEmailList() {
        List<EmailItem> list = new ArrayList<>();
        list.add(new EmailItem("Pinterest", "16 нових пінів, на які варто поглянути", "Ми знайшли нові піни для вас", "12:03", "https://cdn2.iconfinder.com/data/icons/New-Social-Media-Icon-Set-V11/512/pinterest.png"));
        list.add(new EmailItem("Google", "Підтвердіть свою особу", "Хтось здійснив вхід у ваш обліковий запис", "9:24", "https://cdn4.iconfinder.com/data/icons/social-media-icons-the-circle-set/48/google_circle-512.png"));
        list.add(new EmailItem("Medium", "Daily Digest", "Stories for Lena Shestakova", "8:46", "https://cdn0.iconfinder.com/data/icons/social-23/100/social_medium-512.png"));
        list.add(new EmailItem("Kinorama", "Три ультрановых фильма и один постарше", "Лучшая компания на вечер пятницы", "7:00", "https://cdn2.iconfinder.com/data/icons/circle-icons-1/64/filmreel-512.png"));
        list.add(new EmailItem("Yaroslav Polyakov", "Новый материал", "Здраствуйте, Лена. Преподаватель Yaroslav Polyakov добавил материал в курс", "7:00", "https://avatars1.githubusercontent.com/u/15982214?s=400&v=4"));
        list.add(new EmailItem("Discord", "Discord Password Changed", "We've channeled our psionic energy to change your Discord account password. Gonna go get a seltzer to calm down.", "00:00", "https://cdn3.iconfinder.com/data/icons/popular-services-brands-vol-2/512/discord-512.png"));
        return list;
    }


    @Override
    public void itemClickedCallback(int itemPosition) {

        Intent intent = new Intent(this, DetailedEmailActivity.class);
        startActivity(intent);
        intent.putExtra("title", list.get(itemPosition).getTitle() );
        intent.putExtra("subTitle", list.get(itemPosition).getSubTitle());
        intent.putExtra("content", list.get(itemPosition).getContent());
        intent.putExtra("date", list.get(itemPosition).getDate());
        intent.putExtra("imageURL", list.get(itemPosition).getImageURL());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Intent intent = new Intent(this, NewEmailActivity.class);
                startActivity(intent);
        }


    }
}
