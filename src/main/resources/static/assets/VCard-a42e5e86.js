import{p as C,m as o,y as P,n as v,u as j,s as m,a as n,K as q,az as V,al as u,am as S,ay as I,M as b,z as w,aP as J,A as K,aQ as N,aR as Q,aS as U,B as W,aT as X,l as Y,ao as Z,aU as ee,q as ae,E as te,aV as ne,aW as se,aX as de,G as ie,aY as le,aZ as ce,a_ as re,H as ue,a$ as oe,J as h,b0 as ve,b1 as me,L as ye,b2 as ke,b3 as ge}from"./index-1d7bfa1d.js";const fe=C({fluid:{type:Boolean,default:!1},...o(),...P()},"VContainer"),Se=v()({name:"VContainer",props:fe(),setup(e,s){let{slots:t}=s;const{rtlClasses:a}=j();return m(()=>n(e.tag,{class:["v-container",{"v-container--fluid":e.fluid},a.value,e.class],style:e.style},t)),{}}});const be=v()({name:"VCardActions",props:o(),setup(e,s){let{slots:t}=s;return q({VBtn:{variant:"text"}}),m(()=>{var a;return n("div",{class:["v-card-actions",e.class],style:e.style},[(a=t.default)==null?void 0:a.call(t)])}),{}}}),Ce=V("v-card-subtitle"),Ve=V("v-card-title"),pe=C({appendAvatar:String,appendIcon:u,prependAvatar:String,prependIcon:u,subtitle:String,title:String,...o(),...S()},"VCardItem"),Ae=v()({name:"VCardItem",props:pe(),setup(e,s){let{slots:t}=s;return m(()=>{var l;const a=!!(e.prependAvatar||e.prependIcon),y=!!(a||t.prepend),i=!!(e.appendAvatar||e.appendIcon),k=!!(i||t.append),g=!!(e.title||t.title),f=!!(e.subtitle||t.subtitle);return n("div",{class:["v-card-item",e.class],style:e.style},[y&&n("div",{key:"prepend",class:"v-card-item__prepend"},[t.prepend?n(b,{key:"prepend-defaults",disabled:!a,defaults:{VAvatar:{density:e.density,icon:e.prependIcon,image:e.prependAvatar}}},t.prepend):a&&n(I,{key:"prepend-avatar",density:e.density,icon:e.prependIcon,image:e.prependAvatar},null)]),n("div",{class:"v-card-item__content"},[g&&n(Ve,{key:"title"},{default:()=>{var d;return[((d=t.title)==null?void 0:d.call(t))??e.title]}}),f&&n(Ce,{key:"subtitle"},{default:()=>{var d;return[((d=t.subtitle)==null?void 0:d.call(t))??e.subtitle]}}),(l=t.default)==null?void 0:l.call(t)]),k&&n("div",{key:"append",class:"v-card-item__append"},[t.append?n(b,{key:"append-defaults",disabled:!i,defaults:{VAvatar:{density:e.density,icon:e.appendIcon,image:e.appendAvatar}}},t.append):i&&n(I,{key:"append-avatar",density:e.density,icon:e.appendIcon,image:e.appendAvatar},null)])])}),{}}}),Ie=V("v-card-text"),he=C({appendAvatar:String,appendIcon:u,disabled:Boolean,flat:Boolean,hover:Boolean,image:String,link:{type:Boolean,default:void 0},prependAvatar:String,prependIcon:u,ripple:{type:[Boolean,Object],default:!0},subtitle:String,text:String,title:String,...w(),...o(),...S(),...J(),...K(),...N(),...Q(),...U(),...W(),...X(),...P(),...Y(),...Z({variant:"elevated"})},"VCard"),xe=v()({name:"VCard",directives:{Ripple:ee},props:he(),setup(e,s){let{attrs:t,slots:a}=s;const{themeClasses:y}=ae(e),{borderClasses:i}=te(e),{colorClasses:k,colorStyles:g,variantClasses:f}=ne(e),{densityClasses:l}=se(e),{dimensionStyles:d}=de(e),{elevationClasses:x}=ie(e),{loaderClasses:B}=le(e),{locationStyles:T}=ce(e),{positionClasses:L}=re(e),{roundedClasses:_}=ue(e),c=oe(e,t),D=h(()=>e.link!==!1&&c.isLink.value),r=h(()=>!e.disabled&&e.link!==!1&&(e.link||c.isClickable.value));return m(()=>{const R=D.value?"a":e.tag,E=!!(a.title||e.title),M=!!(a.subtitle||e.subtitle),z=E||M,F=!!(a.append||e.appendAvatar||e.appendIcon),G=!!(a.prepend||e.prependAvatar||e.prependIcon),H=!!(a.image||e.image),O=z||G||F,$=!!(a.text||e.text);return ve(n(R,{class:["v-card",{"v-card--disabled":e.disabled,"v-card--flat":e.flat,"v-card--hover":e.hover&&!(e.disabled||e.flat),"v-card--link":r.value},y.value,i.value,k.value,l.value,x.value,B.value,L.value,_.value,f.value,e.class],style:[g.value,d.value,T.value,e.style],href:c.href.value,onClick:r.value&&c.navigate,tabindex:e.disabled?-1:void 0},{default:()=>{var p;return[H&&n("div",{key:"image",class:"v-card__image"},[a.image?n(b,{key:"image-defaults",disabled:!e.image,defaults:{VImg:{cover:!0,src:e.image}}},a.image):n(ye,{key:"image-img",cover:!0,src:e.image},null)]),n(ke,{name:"v-card",active:!!e.loading,color:typeof e.loading=="boolean"?void 0:e.loading},{default:a.loader}),O&&n(Ae,{key:"item",prependAvatar:e.prependAvatar,prependIcon:e.prependIcon,title:e.title,subtitle:e.subtitle,appendAvatar:e.appendAvatar,appendIcon:e.appendIcon},{default:a.item,prepend:a.prepend,title:a.title,subtitle:a.subtitle,append:a.append}),$&&n(Ie,{key:"text"},{default:()=>{var A;return[((A=a.text)==null?void 0:A.call(a))??e.text]}}),(p=a.default)==null?void 0:p.call(a),a.actions&&n(be,null,{default:a.actions}),ge(r.value,"v-card")]}}),[[me("ripple"),r.value&&e.ripple]])}),{}}});export{xe as V,Ve as a,Ie as b,be as c,Se as d};
