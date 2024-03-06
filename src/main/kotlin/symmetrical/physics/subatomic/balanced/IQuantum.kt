package symmetrical.physics.subatomic.balanced

interface IQuantum {
    fun getQuantum()                  : IQuantum?
    fun getQuantumRoot()              : IQuantum
    fun setQuantum(quantum:IQuantum)  : IQuantum

}