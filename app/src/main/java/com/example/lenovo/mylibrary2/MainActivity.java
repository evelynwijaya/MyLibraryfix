package com.example.lenovo.mylibrary2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_noanggota, tv_namaanggota, tv_emailanggota, tv_buku,tv_author,tv_tahun, tv_publisher,tv_tglpinjam ,tv_tglkembali;
    TextView tv_tidakpinjam;
    LinearLayout vgDataPinjam;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();

        member = getIntent().getParcelableExtra("members");
        if (member==null){
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }else {
            tv_noanggota.setText(member.getId_member());
            tv_namaanggota.setText(member.getNamalengkap());
            tv_emailanggota.setText(member.getEmail());

            if (member.getPinjaman().getStatus()!=0){
                Buku buku = member.getPinjaman().getBuku();
                tv_buku.setText(buku.getJudul());
                tv_author.setText(buku.getAuthor());
                tv_tahun.setText(buku.getTahun());

                tv_tglpinjam.setText(member.getPinjaman().getTglpinjam());
                tv_tglkembali.setText(member.getPinjaman().getTglkembali());

                vgDataPinjam.setVisibility(View.VISIBLE);
                tv_tidakpinjam.setVisibility(View.INVISIBLE);


            }else {
                vgDataPinjam.setVisibility(View.GONE);
            }
        }

    }

    private void initLayout() {

        tv_noanggota = (TextView)findViewById(R.id.tv_noanggota);
        tv_namaanggota = (TextView)findViewById(R.id.tv_namaanggota);
        tv_emailanggota= (TextView) findViewById(R.id.tv_emailanggota);

        vgDataPinjam = (LinearLayout) findViewById (R.id.vgDataPinjam);

        tv_buku=(TextView)findViewById(R.id.tv_buku);
        tv_author = (TextView) findViewById(R.id.tv_author);
        tv_tahun = (TextView) findViewById(R.id.tv_tahun);
        tv_publisher = (TextView) findViewById(R.id.tv_publisher);
        tv_tglpinjam = (TextView) findViewById(R.id.tv_tglpinjam);
        tv_tglkembali = (TextView) findViewById(R.id.tv_tglkembali);

        tv_tidakpinjam = (TextView) findViewById(R.id.tv_tidakpinjam) ;

        tv_noanggota.setText(" ");
        tv_namaanggota.setText(" ");
        tv_emailanggota.setText(" ");

       vgDataPinjam.setVisibility(View.INVISIBLE);
    }
}
