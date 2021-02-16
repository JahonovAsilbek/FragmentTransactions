package uz.revolution.fragmentdinamic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import uz.revolution.fragmentdinamic.fragments.FirstFragment
import uz.revolution.fragmentdinamic.fragments.SecondFragment

class MainActivity : AppCompatActivity() {

    private var a:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = FirstFragment()
        val fragment2 = SecondFragment()

        add.setOnClickListener {
            if (a == 0) {
                val supportFragmentManager = supportFragmentManager
                val beginTransaction = supportFragmentManager.beginTransaction()
                beginTransaction.add(R.id.container, fragment)
                beginTransaction.commit()
            } else {
                Toast.makeText(this, "Fragment has already been added", Toast.LENGTH_SHORT).show()
            }
            a=1
        }

        remove.setOnClickListener {
            val supportFragmentManager = supportFragmentManager
            val beginTransaction = supportFragmentManager.beginTransaction()
            if (a == 1) {
                if (getCurrentFragment() is FirstFragment) {
                    beginTransaction.remove(fragment)
                    beginTransaction.commit()
                } else {
                    beginTransaction.remove(fragment2)
                    beginTransaction.commit()
                }
            } else {
            Toast.makeText(this, "Add the fragment first", Toast.LENGTH_SHORT).show()
            }
            a=0
        }

        replace.setOnClickListener {
            val supportFragmentManager = supportFragmentManager
            val beginTransaction = supportFragmentManager.beginTransaction()
            if (a == 1) {
                if (getCurrentFragment() is FirstFragment) {
                    beginTransaction.replace(R.id.container, fragment2)
                    beginTransaction.commit()
                } else {
                    beginTransaction.replace(R.id.container, fragment)
                    beginTransaction.commit()
                }
            } else {
                Toast.makeText(this, "Add the fragment first", Toast.LENGTH_SHORT).show()
            }
        }

        hide.setOnClickListener {
            val supportFragmentManager = supportFragmentManager
            val beginTransaction = supportFragmentManager.beginTransaction()
            if (a == 1) {
                if (getCurrentFragment() is FirstFragment) {
                    beginTransaction.hide(fragment)
                    beginTransaction.commit()
                } else {
                    beginTransaction.hide(fragment2)
                    beginTransaction.commit()
                }
            } else {
                Toast.makeText(this, "Add the fragment first", Toast.LENGTH_SHORT).show()
            }
        }
        
        show.setOnClickListener {
            val supportFragmentManager = supportFragmentManager
            val beginTransaction = supportFragmentManager.beginTransaction()
            if (a == 1) {
                if (getCurrentFragment() is FirstFragment) {
                    beginTransaction.show(fragment)
                    beginTransaction.commit()
                } else {
                    beginTransaction.show(fragment2)
                    beginTransaction.commit()
                }
            } else {
                Toast.makeText(this, "Add the fragment first", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun getCurrentFragment(): Fragment {
        return supportFragmentManager.findFragmentById(R.id.container)!!
    }

}