decl
  i = 1
  c = new (i+1)
in
  c := 2*(!c + i);
  println (!c)
end;;
