package symmetrical.cosmic.physics.atomic.atoms

import symmetrical.cosmic.physics.atomic.atoms.nucleons.INucleons
import symmetrical.cosmic.physics.subatomic.bosons.IEmitter

import symmetrical.cosmic.physics.atomic.atoms.orbitals.IOrbitals
import symmetrical.cosmic.physics.subatomic.balanced.IParticle

/*
https://en.wikipedia.org/wiki/Atom
 */
interface IAtom : Element, IEmitter, IOrbitals, INucleons, IParticle {
}