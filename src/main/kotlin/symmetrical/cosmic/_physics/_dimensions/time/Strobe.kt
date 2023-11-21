package symmetrical.cosmic._physics._dimensions.time

import asymmetrical.machine.time.RequestAnimationFrame
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Strobe (
    private val fermion: IFermion = Fermion(Strobe::class),

    ) :
    IFermion by fermion
{
    constructor() : this(
        Fermion(Strobe::class),
    )

    private val requestAnimationFrame = RequestAnimationFrame().i(this)

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    fun i() : Strobe {
        return this
    }
    fun frame(timestamp:Double): Unit {
        return
    }
    fun start() : Strobe {
        requestAnimationFrame.start()
        return this
    }
}