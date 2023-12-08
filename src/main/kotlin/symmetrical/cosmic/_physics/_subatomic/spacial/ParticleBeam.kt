package symmetrical.cosmic._physics._subatomic.spacial

import asymmetrical.machine.config.Config
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

open class ParticleBeam(
    private val matter: IMatter = Matter(ParticleBeam::class, ParticleBeam::class, true),
    protected val beam     : Beam = Beam()
) : Particle(),
    IMatter by matter,
    IBeam by beam,
    IParticleBeam,
    Emitter
{
    constructor() : this(
        Matter(ParticleBeam::class, ParticleBeam::class, true),
        Beam()
    )
    init {

    }
    object Static {
        const val LAST      : Int = -1
    }



    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

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
        val classId     :String = matter.getClassId()
        val particle    :String = super.emit().radiate()
        val base52Size  :String = Base52.toFixedBase52(Config.getBase52ArraySize(), size())

        var emission = classId+particle+base52Size
        for (i:Int in 0 until size()) {
            val emitter: Emitter = get(i) as Emitter
            emission+=emitter.emit().radiate()
        }

        return emission
    }
    override fun getClassId() : String {
        return matter.getClassId()
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