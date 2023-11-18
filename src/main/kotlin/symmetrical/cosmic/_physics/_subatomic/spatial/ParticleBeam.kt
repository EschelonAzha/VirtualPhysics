package symmetrical.cosmic._physics._subatomic.spatial

import asymmetrical.machine.config.Config
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

open class ParticleBeam(
    private   val entanglement  : IQuantumEntanglement = QuantumEntanglement(),
    protected val beam          : Beam = Beam()
) : Particle(entanglement),
    IBeam by beam,
    IQuantumEntanglement by entanglement,
    IParticleBeam,
    Emitter
{
    constructor() : this(QuantumEntanglement(), Beam()) {
    }
    object Static {
        const val LAST      : Int = -1
    }


    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        val particleRemainder = super.absorb(photon.propagate())
        val (size52, line) = Strings.remainder(3, particleRemainder.radiate())
        val size = Base52.toInt(size52)
        var remainder = line
        for (i in 0 until size) {
            val (emitter, line) = Absorber.materialize(remainder)
            add(emitter)
            remainder = line
            continue
        }
        shrink()
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val classId     :String = getLocalClassId()
        val particle    :String = super.emit().radiate()
        val base52Size  :String = Base52.toFixedBase52(Config.getBase52ArraySize(), size())

        var emission = classId+particle+base52Size
        for (i:Int in 0 until size()) {
            val emitter: Emitter = get(i) as Emitter
            emission+=emitter.emit().radiate()
        }

        return emission
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(ParticleBeam::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    open fun i() : ParticleBeam {
        beam.i()
        return this
    }
    override fun add(particle: IParticle) : IParticle {
        return beam.add(particle) as IParticle
    }
    fun find(particle:IParticle) : Int {
        return beam.find(particle)
    }

    override operator fun get(pos:Int): IParticle {
        val result = beam.get(pos)
        return result as IParticle
    }
    override fun getParticleCore() : Array<IParticle> {
        return getCore() as Array<IParticle>
    }
    override fun set(pos:Int, particle: IParticle) : IParticle {
        return beam.set(pos, particle) as IParticle
    }

}