import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.movies.R
import kotlinx.android.synthetic.main.movie.*

@SuppressLint("Registered")
class movieBack :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie)

        val v: VideoView = findViewById(R.id.videoview)

        val m = MediaController(this)
        m.setAnchorView(v)

        val u:Uri=Uri.parse("https://youtu.be/HuggAsLjRXI")
        videoview.setMediaController(m)
        videoview.setVideoURI(u)
        videoview.start()
    }
}