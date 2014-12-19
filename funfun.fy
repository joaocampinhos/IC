decl
  two = fun f:function, x:int => f ( f ( x )) end
in
  decl x = two ( fun y:int => y+1 end, 2 )
  in
    println x
  end
end;;
