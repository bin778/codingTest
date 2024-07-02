class nodeType {
  constructor(item) {
    this.data = item;
    this.link = null;
  }

  // 연결 리스트와 다른 점은 노드를 생성할 때 마지막 노드를 처음 노드에 연결 시켜주는 것이다.
  firstNodeIn(item) {
    let newNode = new nodeType(item);
    if (this.link === null) {
      this.link = newNode;
      newNode.link = this;
    } else {
      newNode.link = this.link;
      this.link = newNode;
    }
  }

  firstNodeOut() {
    if (this.link === null) return null;
    const tmp = this.link;
    this.link = tmp.link;
  }

  lastNodeIn(item) {
    let newNode = new nodeType(item);
    let p = this;
    if (this.link === null) {
      this.link = newNode;
      newNode.link = this;
    } else {
      while (p.link !== this) {
        p = p.link;
      }
      p.link = newNode;
      newNode.link = this;
    }
  }

  lastNodeOut() {
    if (this.link === null) return null;
    let p = this;
    while (p.link.link !== this) {
      p = p.link;
    }
    p.link = this;
  }

  print() {
    let string = `${this.data} | `;
    // for(let p = this.link; p != this; p=p.link){
    // }
    let p = this.link;
    while (p !== this) {
      string += `${p.data} | `;
      p = p.link;
    }
    string += p.data;
    console.log(string);
  }
}
