package symmetrical.cosmic._physics._subatomic.spacial

import asymmetrical.machine.config.Config
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import kotlin.reflect.KClass

open class ParticleBeam(
    private   val matterAntiMatter : IMatterAntiMatter  = MatterAntiMatter(ParticleBeam::class, ParticleBeam::class),
    protected val _beam            : Beam               = Beam()
) : Particle(),
    IMatterAntiMatter by matterAntiMatter,
    IBeam by _beam,
    IParticleBeam,
    IEmitter
{
    constructor() : this(
        MatterAntiMatter(ParticleBeam::class, ParticleBeam::class),
        Beam()
    )
    init {
    }
    object Static {
        const val LAST      : Int = -1
    }

    open fun i() : ParticleBeam {
        _beam.i()
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        val particleRemainder : Photon      = super.absorb(photon.propagate())
        val (size52:String, line:String)    = Strings.remainder(3, particleRemainder.radiate())
        val size:Int                        = Base52.toInt(size52)
        var remainder : String              = line
        
        for (i in 0 until size) {
            val (emitter, line) = Absorber.materialize(remainder)
            add(emitter)
            remainder = line
        }
        shrink()
        return Photon(remainder)
    }
    override fun add(particle: IParticle) : IParticle {
        return _beam.add(particle) as IParticle
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    fun find(particle:IParticle) : Int {
        return _beam.find(particle)
    }
    override fun find(item:Any) : Int {
        return _beam.find(item)
    }
    override fun find(kClass: KClass<*>) : Int {
        return _beam.find(kClass)
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override operator fun get(pos:Int): IParticle {
        val result = _beam.get(pos)
        return result as IParticle
    }
    override fun getParticleCore() : Array<IParticle> {
        return getCore() as Array<IParticle>
    }
    override fun set(pos:Int, particle: IParticle) : IParticle {
        return _beam.set(pos, particle) as IParticle
    }

    private fun radiate() : String {
        val classId     :String = matterAntiMatter.getClassId()
        val particle    :String = super.emit().radiate()
        if (size() > 140606) {
            println("ParticleBeam::radiate() ************************** MAXIMUM ARRAY SIZE EXCEEDED *********************")
            println("ParticleBeam::radiate() ************************** MAXIMUM ARRAY SIZE EXCEEDED *********************")
            println("ParticleBeam::radiate() ************************** MAXIMUM ARRAY SIZE EXCEEDED *********************")
        }
        val base52Size  :String = Base52.toFixedBase52(Config.getBase52ArraySize(), size())

        var emission = classId+particle+base52Size
        for (i:Int in 0 until size()) {
            val emitter: IEmitter = get(i) as IEmitter
            emission+=emitter.emit().radiate()
        }

        return emission
    }

}