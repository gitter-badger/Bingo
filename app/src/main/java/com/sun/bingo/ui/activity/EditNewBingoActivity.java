package com.sun.bingo.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sun.bingo.R;
import com.sun.bingo.entity.NewBingoEntity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by sunfusheng on 15/7/18.
 */
public class EditNewBingoActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.et_title)
    EditText etTitle;
    @InjectView(R.id.et_content)
    EditText etContent;
    @InjectView(R.id.tv_commit)
    TextView tvCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_new_bingo);
        ButterKnife.inject(this);

        initData();
        initView();
        initListener();
    }

    private void initData() {

    }

    private void initView() {
        initToolBar(toolbar, true, "增加新Bingo");
    }

    private void initListener() {
        tvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commitNewBingo();
            }
        });
    }

    private void commitNewBingo() {
        NewBingoEntity bingoEntity = new NewBingoEntity();
        String title = etTitle.getText().toString().trim();
        if (TextUtils.isEmpty(title)) {
            Toast.makeText(this, "请输入标题", Toast.LENGTH_SHORT).show();
            return ;
        }
        String content = etContent.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
            return ;
        }
        bingoEntity.setTitle(title);
        bingoEntity.setContent(content);
        bingoEntity.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(EditNewBingoActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(EditNewBingoActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
