package game.component

trait Position {
  private var _x: Double = 0.0d
  private var _y: Double = 0.0d

  def x: Double = this._x
  def y: Double = this._y

  def x_=(value: Double): Unit = _x = value
  def y_=(value: Double): Unit = _y = value
}
