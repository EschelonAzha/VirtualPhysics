package symmetrical.cosmic._physics.atomic.bonds.covalent

import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString

open class Molecular(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Molecular::class, Molecular::class),
    private var particleBeam: ParticleBeam = ParticleBeam(),

    ) : Atom(),
    IMatterAntiMatter by matterAntiMatter,
    IParticleBeam by particleBeam,
    IParticle
{
    constructor() : this(
        MatterAntiMatter(Molecular::class, Molecular::class),
        ParticleBeam(),
    )
    object Static {
        const val LAST      : Int = -1
    }

    open fun i() : Molecular {
        particleBeam.i()
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        remainder = this.particleBeam.absorb(remainder)
        shrink()
        return remainder
    }
//    override fun absorb(photon:Photon) : Photon {
//        clear()
//        val remainderAtom:Photon                        = super.absorb(Photon(photon.propagate()))
//        val (particleBeam:Emitter, remainder:String)    = Absorber.materialize(remainderAtom.radiate())
//        this.particleBeam                               = particleBeam as ParticleBeam
//        shrink()
//        return Photon(remainder)
//    }

    fun applyQuarkMomentum(momentum: AngularMomentum) : Molecular {
        for (i in 0 until size()) {
            val atom:Atom = get(i) as Atom
            atom.setQuarkMomentum(CRLFTerminatedMomentum())
        }
        return this
    }
    fun applyQuarkSpin(spin: Spin) : Molecular {
        for (i in 0 until size()) {
            val atom:Atom = get(i) as Atom
            atom.setQuarkSpin(Spin())
        }
        return this
    }
    fun applyElectronSpin(spin: Spin) : Molecular {
        for (i in 0 until size()) {
            val atom:Atom = get(i) as Atom
            atom.setElectronSpin(Spin())
        }
        return this
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    fun findString(value:String) : Int {
        for (i in 0 until size()) {
            val atom:Atom = get(i) as Atom
            if (atom.red().toString() == value)
                return i
        }
        return -1
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    fun findContainsString(contains:String) : Int {
        for (i in 0 until size()) {
            val atom:Atom = get(i) as Atom
            if (atom.red().toString().contains(contains))
                return i
        }
        return -1
    }

    fun materialize(strings:List<String>) : Molecular {
        for (item in strings) {
            add(QString(item))
        }
        shrink()
        return this
    }
    private fun radiate() : String {

        return matterAntiMatter.getClassId()+
                super.emit().radiate()+
                particleBeam.emit().radiate()
    }
}