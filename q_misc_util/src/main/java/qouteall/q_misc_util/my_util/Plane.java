package qouteall.q_misc_util.my_util;

import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

// TODO turn to record in 1.20
public class Plane {
    public final Vec3 pos;
    public final Vec3 normal;
    
    public Plane(Vec3 pos, Vec3 normal) {
        this.pos = pos;
        this.normal = normal.normalize();
    }
    
    public double getDistanceTo(Vec3 point) {
        return normal.dot(point.subtract(pos));
    }
    
    @NotNull
    public Vec3 getProjection(Vec3 point) {
        return point.subtract(normal.scale(getDistanceTo(point)));
    }
    
    public Vec3 getReflection(Vec3 point) {
        return point.subtract(normal.scale(2 * getDistanceTo(point)));
    }
    
    public boolean isPointOnPositiveSide(Vec3 point) {
        return getDistanceTo(point) > 0;
    }
    
    public Plane move(double distance) {
        return new Plane(pos.add(normal.scale(distance)), normal);
    }
    
    public Plane getOpposite() {
        return new Plane(pos, normal.scale(-1));
    }
    
    // TODO remove in 1.20
    @Nullable
    public Vec3 raytrace(Vec3 origin, Vec3 vec){
        return rayTrace(origin, vec);
    }
    
    @Nullable
    public Vec3 rayTrace(Vec3 origin, Vec3 vec) {
        double denominator = normal.dot(vec);
        if (Math.abs(denominator) < 0.0001) {
            return null;
        }
        double t = -getDistanceTo(origin) / denominator;
        if (t <= 0) {
            return null;
        }
        return origin.add(vec.scale(t));
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return pos.equals(plane.pos) &&
            normal.equals(plane.normal);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(pos, normal);
    }
    
    @Override
    public String toString() {
        return "Plane{" +
            "pos=" + pos +
            ", normal=" + normal +
            '}';
    }
    
    public static Plane interpolate(Plane a, Plane b, double progress) {
        Vec3 pos = a.pos.lerp(b.pos, progress);
        Vec3 normal = a.normal.lerp(b.normal, progress);
        return new Plane(pos, normal);
    }
    
    public Plane getParallelPlane(Vec3 pos) {
        return new Plane(pos, normal);
    }
}
