require_relative 'names'
require_relative 'match'

names = Names.new
names.add(1, 'Ross')
names.add(2, 'Monica')
names.add(3, 'Chandler')
names.add(4, 'Phoebe')
names.add(5, 'Joey')
names.add(6, 'Rachel')

match = Match.new names
match.add([6, 4, 2], [3, 5, 1])
match.add([2, 6, 4], [5, 1, 3])
match.add([6, 4, 2], [1, 5, 3])
match.run
