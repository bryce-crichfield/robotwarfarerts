package game.component

trait Physics {
  private var _vx: Double = 0.0d
  private var _vy: Double = 0.0d
  private var _ax: Double = 0.0d
  private var _ay: Double = 0.0d

  def vx: Double = _vx
  def vy: Double = _vy
  def ax: Double = _ax
  def ay: Double = _ay

  def vx_=(value: Double): Unit = _vx = value
  def vy_=(value: Double): Unit = _vy = value
  def ax_=(value: Double): Unit = _ax = value
  def ay_=(value: Double): Unit = _ay = value
}
