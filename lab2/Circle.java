package lab2;
import lab2.Animal;

public class Circle {
    private float _radius;
    private float[] _centerCoords;

    public Circle(float radius, float x, float y){
        _radius = radius;
        _centerCoords = new float[]{x, y};
    }

    public Circle() {
        _centerCoords = new float[2];
    }

    public Circle(float radius) {
        _radius = radius;
        _centerCoords = new float[2];
    }

    public Circle(float x, float y){
        _centerCoords = new float[]{x, y};
    }

    public float getRadius(){
        return _radius;
    }

    public void setRadius(float radius) {
        if (radius > 0) {
            _radius = radius;
        } else {
            System.out.println("Radius should be > 0");
        }
    }

    public float[] getCenterCoords(){
        return _centerCoords;
    }

    public void setCenterCoords(float x, float y) {
        if (_centerCoords == null) {
            _centerCoords = new float[2];
        }
        _centerCoords[0] = x;
        _centerCoords[1] = y;
    }

    public float getX() {
        return (_centerCoords != null) ? _centerCoords[0] : 0;
    }

    public void setX(float x) {
        if (_centerCoords == null) {
            _centerCoords = new float[2];
        }
        _centerCoords[0] = x;
    }

    public float getY() {
        return (_centerCoords != null) ? _centerCoords[1] : 0;
    }

    public void setY(float y) {
        if (_centerCoords == null) {
            _centerCoords = new float[2];
        }
        _centerCoords[1] = y;
    }

    public double calcArea() {
        if (_radius > 0 && _centerCoords != null){
            return Math.PI * _radius * _radius;
        } else {
         System.out.println("Radius and center coordinates must be set first.");
         return -1;
        }
    }


}