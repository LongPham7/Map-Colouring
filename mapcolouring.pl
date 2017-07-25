% This code is from page 256 of The Art of Prolog

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

test_colour(Name, Map) :-
  map(Name, Map),
  colours(Name, Colours),
  colour_map(Map, Colours).

map(test, [region(a,A,[B,C,D]), region(b,B,[A,C,E]), region(c,C,[A,B,D,E,F]),
region(d,D,[A,C,F]), region(e,E,[B,C,F]), region(f,F,[C,D,E])]).

colours(X,[red,yellow,blue,white]).
