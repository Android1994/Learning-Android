package com.example.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> mMsgList = new ArrayList<>();

    private EditText inputText;
    private Button send;

    private RecyclerView msgRecyclerView;
    private MsgAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsg();

        inputText = (EditText)findViewById(R.id.edit_text);
        send = (Button)findViewById(R.id.button_send);
        msgRecyclerView = (RecyclerView)findViewById(R.id.msg_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new MsgAdapter(mMsgList);
        msgRecyclerView.setAdapter(mAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String context = inputText.getText().toString();
                if(!"".equals(context)){
                    Msg msg = new Msg(context,Msg.TYPE_SENT);
                    mMsgList.add(msg);
                    mAdapter.notifyItemInserted(mMsgList.size()-1); //当有新消息时，刷新ListView中的显示
                    msgRecyclerView.scrollToPosition(mMsgList.size()-1);//将ListView定位到最后一行
                    inputText.setText(""); //清空inputText
                }
            }
        });

    }

    private void initMsg(){
        Msg msg1 = new Msg("Hello boy!",Msg.TYPE_RECEVIED);
        mMsgList.add(msg1);
        Msg msg2 = new Msg("Hello! Who is that?",Msg.TYPE_SENT);
        mMsgList.add(msg2);
        Msg msg3 = new Msg("This is Tom.Nice talking to you!",Msg.TYPE_RECEVIED);
        mMsgList.add(msg3);
    }
}
