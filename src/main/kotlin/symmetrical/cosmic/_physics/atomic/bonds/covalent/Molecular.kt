package symmetrical.cosmic._physics.atomic.bonds.covalent

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.spatial.IParticleBeam
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Molecular(
    private val fermion: IFermion = Fermion(),
    private var particleBeam:ParticleBeam=ParticleBeam(),

    ) : Atom(fermion),
    IFermion by fermion,
    IParticleBeam by particleBeam,
    IParticle
{
    constructor() : this(
        Fermion(),
        ParticleBeam(),
    )
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

        clear()
        val remainderAtom: Photon = super.absorb(photon.propagate())
        val photon : Photon = this.particleBeam.absorb(remainderAtom)
        shrink()
        return photon
    }
//    override fun absorb(photon:Photon) : Photon {
//        clear()
//        val remainderAtom:Photon                        = super.absorb(Photon(photon.propagate()))
//        val (particleBeam:Emitter, remainder:String)    = Absorber.materialize(remainderAtom.radiate())
//        this.particleBeam                               = particleBeam as ParticleBeam
//        shrink()
//        return Photon(remainder)
//    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val particleBeamEmission = particleBeam.emit().radiate()
        return getLocalClassId()+super.emit().radiate()+particleBeamEmission
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Molecular::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    open fun i() : Molecular {
        particleBeam.i()
        return this
    }
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

    fun findString(value:String) : Int {
        for (i in 0 until size()) {
            val atom:Atom = get(i) as Atom
            if (atom.red().toString() == value)
                return i
        }
        return -1
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
}