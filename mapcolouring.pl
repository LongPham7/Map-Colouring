% This code is is a variant of the one from page 256 of The Art of Prolog.

colour_map([Region|Regions], Colours) :-
  colour_region(Region, Colours),
  colour_map(Regions, Colours).
colour_map([], Colours).

colour_region(region(Name, Colour, Neighbours), Colours) :-
  select(Colour, Colours, Colours1),
  members(Neighbours, Colours1).

members([X|Xs], Ys) :- member(X, Ys), members(Xs, Ys).
members([], Ys).

% Test rig

test_colour(Name, Colours, Map) :-
  map(Name, Map), colour_map(Map, Colours).

map(test, [region(a,A,[B,F]), region(b,B,[A,C,F]), region(c,C,[B,D,F]),
region(d,D,[C,E,F]), region(e,E,[D,F]), region(f,F,[A,B,C,D,E]), region(g, G, [])]).
