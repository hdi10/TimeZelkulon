package de.zelkulon.timezelkulon.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import de.zelkulon.timezelkulon.model.MyRoute
import de.zelkulon.timezelkulon.model.MyWayPoint

@Dao
interface RouteDao {
    @Insert
    suspend fun insertRoute(route: MyRoute): Long

    @Insert
    suspend fun insertWayppoint(wayPoint: MyWayPoint)

    @Query("SELECT * from myroutes")
    suspend fun getAllRoutes():List<MyRoute>

    @Query("SELECT * FROM waypoints where routeId = :routeId")
    suspend fun getWaypointsForRoute(routeId:Long):List<MyWayPoint>
}