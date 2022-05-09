package contagiouscode.mirsengar.fitlance.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sessions")
data class Session(
          @PrimaryKey(autoGenerate = true)
          var sessionId : Long = 0L ,
          @ColumnInfo(name = "start_time_milli")
          val startTimeMilli : Long = System.currentTimeMillis() ,
          @ColumnInfo(name = "end_time_milli")
          var endTimeMilli : Long = startTimeMilli ,
          @ColumnInfo(name = "training_type")
          var trainingType : String = "" ,
)